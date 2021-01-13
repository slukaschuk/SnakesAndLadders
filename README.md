# SnakesAndLadders

Snakes and Ladders Kata (http://agilekatas.co.uk/katas/SnakesAndLadders-Kata)

#Info

The functionality described in the first feature has been implemented
 - Token Can Move Across the Board
 - Moves Are Determined By Dice Rolls
 - Player Can Win the Game

Added one endpoint to test the player's ability to make movements.

##### How to check

Recommended to import project to IDE and run SnakesAndLaddersApplication.
After the application is launched, you can send POST http request to endpoint - http://localhost:8080/game/player

The Content-Type of request should be "application/json".
In the request body, you need to pass the player's model, indicating his token position for example

{
"data": {
"attributes": {
"token": {
"position" : 95
}
}
}
}
