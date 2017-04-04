tracker = 0

while True:
	commandFile = open('/home/eadom/Desktop/writer.txt')
	commandFile.seek(tracker)
	command = commandFile.read()
	fileBytePos = commandFile.tell()
	commandFile.close()
