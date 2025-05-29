
'''
Book - Cracking the Coding Interview

Chapter 3 - Stacks and Queues
Question 3.6


'''


from enum import Enum
from collections import deque

class AnimalType(Enum):
    CAT=0,
    DOG=1
    
class Animal:
    def __init__(self, name, animalType):
        self.name = name
        self.animalType = animalType
        self.order = 0

    def setOrder(self, order):
        self.order = order

    def getOrder(self):
        return self.order

    def isOlderThan(self, other):
        return self.order < other.getOrder()
        
class AnimalShelter:
    def __init__(self):
        self.catInfo = deque()
        self.dogInfo = deque()
        self.order = 0

    def enqueue(self, animal):
        animal.setOrder(self.order)
        self.order += 1
        if animal.animalType == AnimalType.CAT:
            self.catInfo.append(animal)
        elif animal.animalType == AnimalType.DOG:
            self.dogInfo.append(animal)

    def dequeueCat(self):
        if self.catInfo:
            return self.catInfo.popleft()
        return None

    def dequeueDog(self):
        if self.dogInfo:
            return self.dogInfo.popleft()
        return None

    def dequeue_any(self):
        if not self.catInfo:
            return self.dequeueDog()
        if not self.dogInfo:
            return self.dequeueCat()

        cat = self.catInfo[0]
        dog = self.dogInfo[0]
        if cat.isOlderThan(dog):
            return self.dequeueCat()
        else:
            return self.dequeueDog()
        
    
class Cat(Animal):
    def __init__(self, name):
        super().__init__(name, AnimalType.CAT)

class Dog(Animal):
    def __init__(self, name):
        super().__init__(name, AnimalType.DOG)
        

        
    
        
    
        
    
    
        
