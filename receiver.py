buffersize = 2**16
with open(C:\Users\Ethan\Desktop\Testing) as f: 
    while True:
        lines_buffer = f.readlines(buffersize)
        if not lines_buffer:
            break
        for line in lines_buffer:
	    a = line
            print line

commandsToSend = line.split()

for i in range(0,len(commandsToSend)):
	print "Command %d : %s" % (i, commandsToSend[i])

