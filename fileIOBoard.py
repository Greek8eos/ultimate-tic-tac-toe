# This file processes all information to be sent to Java or received by Python. It also clears all processed content in the file.

import sys
import time
import os

typeOfReceivingCommands = ['Feedback', 'LocalBoardWon', 'LocalBoardChange', 'Won'] #Commands to receive from backend (Java)
typeOfTransmittingCommands = ['Option', 'Place'] #Commands to send to backend (Java)

def readInput(): #waits for command to send to Java, reads the command, clears file contents
  size = os.path.getsize('communication.txt')
  time.sleep(1)
 # while size == os.path.getsize('communication.txt'):
  communication = open('communication.txt', 'r')
  line = communication.readline()
  while len(line) == 0 or line.split()[0] != 'Feedback':
    communication = open('communication.txt', 'r+')
    line = communication.readline()
    communication.close()
   #lineNext = communication.readline() #introduced so that line is not read before the backend finishes inputting the line
       # if len(lineNext) != 0:
        #  line.append(lineNext)
  commands, numCommands = processBackend(line)
  communication.close()
  open('communication.txt', 'w').close()
  print line
  return numCommands, commands


def wrapCommand(command, value): #Wraps information to send to Backend
  if command == 'Option':
    return ''
  else:
    return str(value)
    
def writeInput(command): #Sends information to backend
  global communication
  communication = open('communication.txt', 'r+')
  prefix = command.split()[0]
  writeCommand = wrapCommand(prefix, command[len(prefix)+1:len(command)])
  communication.write(prefix + ' ' + writeCommand) #
  print prefix + ' ' + writeCommand
  time.sleep(0.2)
  open('communication.txt', 'w').close()
  communication.close()
 # communication.truncate()

 
def processBackend(line): #Returns the string sent from backend to Python along with processed command
  commands = line.split()
  numCommands = countNumCommands(commands)
  return commands, numCommands
  
def countNumCommands(commands): #Processes information from Java (backend) to Python
  global typeOfInputCommands
  commandIndices = []
  for iterat in range(0, len(commands)):
    if commands[iterat] in typeOfReceivingCommands:
      commandIndices.append([iterat, commands[iterat]])
  return commandIndices

