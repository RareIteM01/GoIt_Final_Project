# Java Core Course Team Project: "Cities" Game

## Description

Create a simple graphical game called "Cities" using Java's AWT and Swing libraries. The game involves the user and the computer taking turns to name cities based on the last letter of the previous city's name.

## Rules

- Cities cannot be repeated.
- Maintain a collection of cities (at least 50 cities) that the user and computer can use.
- Keep track of and validate user input.

## Components

- **computerList:** ArrayList containing all cities available to the computer.
- **humanList:** ArrayList containing all cities added by the user.

## Checks and Validations

- Check if the entered word is already in the list.
- Check the API of existing cities to verify the input.
- Before the computer responds, verify if the user's last letter matches the first letter in the computer's list.
- Ensure the user's input is not equal to "Я здаюсь."

## Victory Conditions

- For the user: When the computer runs out of cities to respond with.
- For the computer: When the user enters "Я здаюсь."

## UI Specifications

1. **Welcome Window (Start of Game)**
   - Width: ~400px
   - Height: ~100px
   - Content: Welcome message and a "Start" or "OK" button.
   - Appears centered on the screen.

2. **Main Game Window**
   - Width: ~400px
   - Height: ~500px
   - Content: Text field for user input, label displaying the computer's response, and a "Make Move" button.
   - Appears centered on the screen.

## End of Game

- When the game ends (due to cities being exhausted or the user giving up), show a modal dialog box displaying the final score and a farewell message.
- Customize the application icon and style according to preferences.

## Implementation

- Learn and utilize Java's AWT and Swing libraries for creating the graphical user interface.
- Develop data structures (ArrayLists) for tracking cities and user/computer moves.
- Implement checks and validations as specified.
- Implement the game logic following the described rules.

## Repository Organization

- **src:** Contains the Java source code files.
- **resources:** Contains any additional resources (images, icons, etc.).
- **README.md:** Provides an overview of the project, its purpose, and instructions for running the game.

## Note

This project is designed to demonstrate Java programming skills while incorporating graphical user interface elements using AWT and Swing libraries. The goal is to create an interactive "Cities" game with appropriate validation and user-friendly UI.
