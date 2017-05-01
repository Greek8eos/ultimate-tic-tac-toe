import unittest
from mapping import *
import numpy

class testMapping(unittest.TestCase):

	def checkEquality(self, tuple1, tuple2):
		for i in range(0, 4):
			if numpy.array([tuple1[i] != tuple2[i]]).all():
				return False
		return True

	def testMapToBoard(self):
		test1 = mapToBoard(0,0) #origin
		tup = ([0,0], numpy.array([23,23]), 0, 0)
		eq = self.checkEquality(test1, (tup))
		self.assertEquals(True, eq)
		tup = ([2,0], numpy.array([0,455]), 8, 6)
		test2 = mapToBoard(0, 455) #y-axis
		eq = self.checkEquality(test2, (tup))
		self.assertEquals(True, eq)
		test3 = mapToBoard(455, 0) #x-axis
		tup = ([0,2], numpy.array([455,0]), 64, 2)
		eq = self.checkEquality(test3, (tup))
		test4 = mapToBoard(455,455) #outerboundary
		tup = ([2,2], numpy.array([455,455]), 80, 8)
		eq = self.checkEquality(test4, (tup))
		self.assertEquals(True, eq)

	def testIndex(self):
		self.assertEquals(0, index([(0,0),(0,0)], (0,0)))
		self.assertEquals(-1, index([(0,0),(0,0)], (-1,-1)))
		self.assertEquals(1, index([(2,2), (1,1)], (1,1)))

	def testMapLocalBoard(self):
		test1 = mapLocalBoard(1, 0)
		self.assertEquals(tuple([167,0]), tuple(test1))
		test2 = mapLocalBoard(2, 0)
		self.assertEquals(tuple([334,0]), tuple(test2))
		test3 = mapLocalBoard(8, 0)
		self.assertEquals(tuple([334,334]), tuple(test3))

	def testConvertToLocalLocation(self):
		test1 = convertToLocalLocation(0,0)
		self.assertEquals(test1, 0)
		test2 = convertToLocalLocation(8,8)
		self.assertEquals(test2, 8)
		test3 = convertToLocalLocation(4,4)
		self.assertEquals(test3, 4)
		test4 = convertToLocalLocation(0,8)
		self.assertEquals(test4, 2)
		test5 = convertToLocalLocation(8,0)
		self.assertEquals(test5, 6)

if __name__ == '__main__':
	unittest.main()
