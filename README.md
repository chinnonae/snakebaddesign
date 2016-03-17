#SKE snakebaddesign


###Where does GRASP applied?
* Board, Dice, Player, and Squares are created for low coupling and reusability

* GameLogic is created for separate most of the snake-ladder's logic from the GameActivity.

* Square is implemented for the polymorphism (in case of there are many types of the square)

* GameLogic contain Board becuase it is creator of the Board
