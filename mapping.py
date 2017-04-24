#This file takes care of all math involving a mapping from pixels to positions on the board and vice-versa. It also converts row,col positions on the board to the number of the localBoard. 

import numpy
from functools import partial

def mapToBoard(x, y): #Converts pixel value to information in the frame of the board and localboard
	validIndices = numpy.array([[23,23], [23,70], [23,123], [23,187], [23,240], [23,286], [23,360], [23,400], [23,455], [72,23], [72,70], [72,123], [72,187], [72,240], [72,286], [72,360], [72,400], [72,455], [121,23], [121,70], [121,123], [121,187], [121,240], [121,286], [121,360], [121,400], [121,455], [190,23], [190,70], [190,123], [190,187], [190,240], [190,286], [190,360], [190,400], [190,455], [240,23], [240,70], [240,123], [240,187],  [240,240], [240,286], [240,360], [240,400], [240,455], [290,23], [290,70], [290,123], [290,187], [290,240], [290,286], [290,360], [290,400], [290,455], [360,23], [360,70], [360,123], [360,187], [360,240], [360,286], [360,360], [360,400], [360,455], [405,23], [405,70], [405,123], [405,187], [405,240], [405,286], [405,360], [405,400], [405,455], [457,23], [457,70], [457,123], [457,187], [457,240], [457,286], [457,360], [457,400], [457,455]])
	dist=lambda s,d: (s[0]-d[0])**2+(s[1]-d[1])**2
	query = [x,y]
	placementLocation = min(validIndices, key=partial(dist, query))
	position = index(validIndices, numpy.array(placementLocation))
	positionLocation = [position % 9, int(position / 9)]
	globalBoardNumber = convertToLocalLocation(positionLocation[0], positionLocation[1])
	positionLocation = [positionLocation[0] % 3, positionLocation[1] % 3]
	return positionLocation, placementLocation, position, globalBoardNumber

def mapLocalBoard(boardNumber, numBoards): #converts information in frame of the board to pixel equivalent
	boardLocation = [boardNumber % 3, int(boardNumber / 3)]
	boardPlacement = numpy.array(boardLocation) * numpy.array([167, 167])
	numBoards += 1
	return boardPlacement


def convertToLocalLocation(row, col): #converts row,col to singly-indexed board number
	numRow = int((row % 9)/3)
	numCol = int((col % 9)/3)
	return numRow * 3 + numCol


def index(array, item): #used to retrieve index of item in array
    for idx in range(0, len(array)):
        if array[idx][0] == item[0] and array[idx][1] == item[1]:
            return idx
    return -1
