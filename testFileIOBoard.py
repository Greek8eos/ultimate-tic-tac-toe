import unittest
import filecmp
from fileIOBoard import *

class testFileIOBoard(unittest.TestCase):

	def testWriteInput(self):
		writeInput('Place 0 1 0','communications1.txt')
		self.assertTrue(open('test1.txt','rb').read().strip()==open('communications1.txt','rb').read().strip())
		writeInput('Option 0','communications2.txt')
		self.assertTrue(open('test2.txt','rb').read().strip()==open('communications2.txt','rb').read().strip())
		writeInput('Option 1','communications3.txt')
		self.assertTrue(open('test3.txt','rb').read().strip()==open('communications3.txt','rb').read().strip())

	def testProcessBackend(self):
		string = "Feedback 0 LocalBoardWon 5 LocalBoardChange 3 Won 1"
		self.assertEquals((string.split(), [[0, 'Feedback'], [2, 'LocalBoardWon'], [4, 'LocalBoardChange'], [6, 'Won']]), processBackend(string))
		string = "Feedback 0 LocalBoardWon 5"
		self.assertEquals((string.split(), [[0, 'Feedback'], [2, 'LocalBoardWon']]), processBackend(string))
		string = ""
		self.assertEquals(([], []), processBackend(string))

	def testWrapCommand(self):
		self.assertEquals('1', wrapCommand("Options", 1))
		self.assertEquals('0 1 0', wrapCommand("Place", '0 1 0'))


if __name__ == '__main__':
	unittest.main()
