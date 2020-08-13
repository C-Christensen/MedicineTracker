# MedicineTracker

PillSchedule is a medicine tracker app that helps users to keep track of their medicine intake. It also has a diary activity, where the user can record any type of information such as symptoms, or anything related to the medicine being taken. Finally, the third activity is a map that can be used to locate drugstores.

![Screen Shot 2020-08-13 at 3 09 40 AM](https://user-images.githubusercontent.com/52684850/90122832-c277c380-dd12-11ea-8491-ffdf6f2214eb.png)

The app has an uncomplicated and efficient user interface. In the application main page, the user has access to information such as medicine name, quantity, type and the date/time the data was recorded. The data is stored in an SQLite database.

![Screen Shot 2020-08-13 at 3 13 12 AM](https://user-images.githubusercontent.com/52684850/90122950-f0f59e80-dd12-11ea-8c7b-e8309d0c41d4.png)

By clicking on the red circle, the user is redirected to a new activity where they can add information about a specific medicine intake. 

![Screen Shot 2020-08-13 at 3 14 17 AM](https://user-images.githubusercontent.com/52684850/90123068-1a162f00-dd13-11ea-91f7-4948aba9921f.png)

When the user saves the activity (by clicking on the icon located in the upright corner), the new data is displayed on the main page and a toast message can be seen to let the user know the medicine has been saved. The user can also choose to cancel the activity by clicking on the up left corner icon.

![Screen Shot 2020-08-13 at 3 15 09 AM](https://user-images.githubusercontent.com/52684850/90123186-4336bf80-dd13-11ea-89c9-e5fba748f5cd.png)

The data can be deleted in two different ways. The user can swipe each entry (either to the left or the right of the screen)

![Screen Shot 2020-08-13 at 3 15 17 AM](https://user-images.githubusercontent.com/52684850/90123217-52b60880-dd13-11ea-9cc7-815d22075a36.png)

or, they can click on the menu located on the upright corner and delete all the entries at once

![Screen Shot 2020-08-13 at 3 15 24 AM](https://user-images.githubusercontent.com/52684850/90123263-62355180-dd13-11ea-9af7-d1ff4f990273.png)

The notes activity can be used as a diary to record anything related to medicine intake. Just like in the medicine activity, the user can click on the red circle to add a new note

![Screen Shot 2020-08-13 at 3 17 30 AM](https://user-images.githubusercontent.com/52684850/90123421-a32d6600-dd13-11ea-9f7a-31b4e1c65d53.png)

Then, a dialog box is displayed and the user can enter the desired information 

![Screen Shot 2020-08-13 at 3 17 36 AM](https://user-images.githubusercontent.com/52684850/90123450-b0e2eb80-dd13-11ea-947e-92efd0b8682c.png)

The content is displayed in the notes activity after the user saves it. Automatically, the date/time the note was created will be displayed on the bottom of each entry

![Screen Shot 2020-08-13 at 3 17 43 AM](https://user-images.githubusercontent.com/52684850/90123526-d1ab4100-dd13-11ea-9d2c-b26903d97984.png)

When the user clicks on the entry, a dialog box is displayed with two options, the first one is to edit the notes and the second is to delete it

![Screen Shot 2020-08-13 at 3 17 48 AM](https://user-images.githubusercontent.com/52684850/90123564-e25bb700-dd13-11ea-8555-7c526971ae34.png)

At last, PillSchedule integrates a google maps API, where the user can locate drugstores. First, the user needs to allow access to their location

![Screen Shot 2020-08-13 at 3 17 54 AM](https://user-images.githubusercontent.com/52684850/90123591-ef78a600-dd13-11ea-97c5-8bf4b9c3541f.png)

Then, the user can type the desired address to locate a drugstore of their preference

![Screen Shot 2020-08-13 at 3 18 06 AM](https://user-images.githubusercontent.com/52684850/90123627-fd2e2b80-dd13-11ea-9754-ab1b4c7e9d93.png)
