#This is the function to run the GUI and main control loop. To run, scroll to the bottom of the script: Download the respective images, create a 'communications.txt' file and change the filenames to reflect the path of each file. Contact edessale@gmu.edu for information.

import pygame
import time
import numpy
import os
import sys
import fileIOBoard
from fileIOBoard import *
from mapping import *
from functools import partial

state = options = blueWon = redWon = False #state of the screen (title screen, options screen)
numTurns = numBoards = 0 #number of turns taken so far, number of won boards
sides = ['red', 'blue']
xCount = oCount = 0 #each side number of turns
prevPos = (0,0)
(width, height) = (486, 480) #size of game
screen = pygame.display.set_mode((width, height)) #screen of the GUI
running = True
positions = numpy.array([[-1,-1]]*81)
boardPositions = numpy.array([[-1,-1, 'g']]*9)
localBoardChange = [False, -1, -1]
prevPosInsert = [-1, -1]
restrainedBoardNumber = -1



def updateBoardStart(): #constantly checking for response on title screen
	global state, options
    	screen.blit(img,(0,0))
    	pygame.display.flip()
	if pygame.mouse.get_pressed()[2]:
		state = True
		options = True
		time.sleep(0.3)
	for event in pygame.event.get():
		a = 1
	pygame.event.pump()

def optionBoardStart(): #loading options page, checking for either option 1 or option 2
	global state, options
    	screen.blit(optionImage,(0,0))
    	pygame.display.flip()
	if pygame.mouse.get_pressed()[2]:
		location = [pygame.mouse.get_pos()[0], pygame.mouse.get_pos()[1]]
		if 150 < location[0] < 350 and 134 < location[1] < 160:
			wait('Options', 1)
			options = False
  		  	screen.blit(board, (0,0))
		elif 150 < location[0] < 350 and 211 < location[1] < 238:
			wait('Options', 2)
			options = False
    			screen.blit(board, (0,0))
		time.sleep(0.3)
	for event in pygame.event.get():
		a = 1
	pygame.event.pump()

def wait(prefix, position): #Writes a command to send to the backend, waits for a command to be sent back
	global communication
	inputCommand = ''
	if prefix == 'Options':
		writeInput(prefix + ' ' + str(position) + ' ')
		return
	else:
		for i in range(0, len(position)):
			inputCommand += (' ' + str(position[i]))
		overallCommand = prefix + inputCommand
		writeInput(overallCommand)
		return readInput()

def updateBoards(screen, num, side): #Keeps track of victorious localBoards
	global numBoards, boardPositions
	boardPlacement = mapLocalBoard(num, numBoards)
	if side == 'b':
		boardPositions[numBoards] = numpy.array([boardPlacement[0],boardPlacement[1],'b'])
	else:
		boardPositions[numBoards] = numpy.array([boardPlacement[0],boardPlacement[1],'r'])
	if boardPositions[numBoards][2] == 'b':
		screen.blit(blueWon, [int(boardPositions[numBoards][0]), int(boardPositions[numBoards][1])])
	if boardPositions[numBoards][2] == 'r':
		screen.blit(redWon, [int(boardPositions[numBoards][0]), int(boardPositions[numBoards][1])])


def updateBoardPositions(xMoves, oMoves, turn): #This is the repeatedly called method that manages the screen of the GUI, and shares some of the game logic with the backed (determining if move is valid or not)
	global numTurns, numBoards, positions, communication, boardPositions, boards, prevPosInsert, restrainedBoardNumber
	
	clock = pygame.time.Clock()

	if numTurns % 2 == 0:
		currTurn = 'r'
	else:
		currTurn = 'b'

    	for j in range(0, len(oMoves)):
        	screen.blit(bigO, oMoves[j])
    	for i in range(0, len(xMoves)):
        	screen.blit(bigx, xMoves[i])

    	pygame.display.flip()
	for event in pygame.event.get():
        	if event.type == pygame.QUIT:
	    		sys.exit(1)
    		if event.type == pygame.MOUSEBUTTONDOWN:
			position, appender, localBoardNum, globalBoardNumber = mapToBoard(pygame.mouse.get_pos()[0], pygame.mouse.get_pos()[1]) #write position
			#print position
			numBoard = convertToLocalLocation(position[0], position[1])
			#updateBoards(screen, 0, 'b')
			#updateBoards(screen, 9, 'r')
			commandList = []
			if restrainedBoardNumber != -1:
				if restrainedBoardNumber == globalBoardNumber:
					msg = position + [globalBoardNumber]
					commandList, line = wait('Place', msg)
			else:
				msg = position + [globalBoardNumber]
				commandList, line = wait('Place', msg)

			for i in range(0, len(commandList)):
				if commandList[i][1] == 'Won':
					if line[commandList[i][0] + 1] == '1':
						time.sleep(5)
					#	print currTurn + 'won!'
						sys.exit()
				if commandList[i][1] == 'Feedback':
					feedback = int(line[commandList[i][0] + 1])
					if feedback == 1:
						appender[0] -= 25
						appender[1] -= 25

						if turn == 'red':
		    					xMoves.append(appender)
						else:
		    					oMoves.append(appender)
						numTurns += 1
				if commandList[i][1] == 'LocalBoardChange':
					newBoard = int(line[commandList[i][0] + 1])
					posInsert = mapLocalBoard(newBoard, numBoards)
					if feedback != 0:				
						screen.blit(board, (prevPosInsert[0], prevPosInsert[1]), pygame.Rect(prevPosInsert[0], prevPosInsert[1], 150, 150))
						if currTurn == 'r':
							screen.blit(blue, posInsert)
						if currTurn == 'b':
							screen.blit(red, posInsert)
						prevPosInsert = posInsert
						restrainedBoardNumber = newBoard
				if commandList[i][1] == 'LocalBoardWon':
					if line[commandList[i][0] + 1] == '1':
						newBoardWon = numBoard
						print newBoardWon
						updateBoards(screen, globalBoardNumber, currTurn)



			dt = clock.tick(60)
	pygame.event.pump()
	return xMoves, oMoves



pygame.init()
bigO = pygame.image.load('/home/eadom/Desktop/O-tic-tac-toe.png') #CHANGE ALL FILENAMES PRESENTED HERE AND BELOW
bigx = pygame.image.load('/home/eadom/Desktop/x-tic-tac-toe.png')
blue = pygame.image.load('/home/eadom/Desktop/blue2.png')
red = pygame.image.load('/home/eadom/Desktop/red2.jpg')
blueWon = pygame.image.load('/home/eadom/Desktop/blue.png')
redWon = pygame.image.load('/home/eadom/Desktop/red.png')
optionImage = pygame.image.load('/home/eadom/Desktop/options.png').convert_alpha()
img = pygame.image.load('/home/eadom/Desktop/title.png').convert_alpha()
board = pygame.image.load('/home/eadom/Desktop/ult_tic_tac_toe.png').convert_alpha()
pygame.display.set_caption('Ultimate Tic-tac-toe')
#fileToProcess = file.open('file.txt')
xmoves = []
omoves = []
numTurns = 0

while running: 
	if state == False:
     		updateBoardStart()
	elif options == True:
		optionBoardStart()
	elif options == False:
		currTurn = sides[numTurns % 2]
		xmoves, omoves = updateBoardPositions(xmoves, omoves, currTurn)
		




