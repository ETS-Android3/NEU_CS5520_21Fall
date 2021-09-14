# NEU_CS5520_21Fall

### Welcome!

This is the repository I prepared for **CS5520** - Mobile Application Development - 2021 fall. You will see all the code I built for this course here. And I will also summarize the content learned in each lesson.

# Lessons

Here is the lessions that I took during this semester.

## Lesson 1_1 Android Studio and Hello World
Here is the [Link](https://github.com/BingfanTian96/NEU_CS5520_21Fall/tree/main/lesson1_1) to my code.

### Output:
![Lesson 1_1 output](https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/Lesson%201_1.png)

The main purpose of this lesson is to understand Android Studio and create the first Hello World application:

- Create the first Hello World project and explore the characteristics of Android studio development tools.
- Understand the Gradle Scripts folder, such as build.gradle(Project:) and build.gradle(Module:app).
- Learn how to change the application Gradle configuration.
- Learn how to add log statements to my app.

### Homework:
- **Question 1**: What is the name of the layout file for the main activity?
	- `activity_main.xml`
- **Question 2**: What is the name of the string resource that specifies the application's name?
	- `app_name`
- **Question 3**: Which tool do you use to create a new emulator?
	- `AVD Manager`
- **Question 4**: You see the statement in the **Logcat** pane if the Log level menu is set to which of the following?
	- `Verbose`
	- `Debug`
	- `Info`

## Lesson 1_2_A First Interactive UI
Here is the [Link](https://github.com/BingfanTian96/NEU_CS5520_21Fall/tree/main/lesson1_2) to my code.

### Output:
![Lesson 1_2 output overview](https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson%201_2%20p1.png)
![Lesson 1_2 toast function](https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson%201_2%20p2.png)
![Lesson 1_2 count function](https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson%201_2%20p3.png)

The main purpose of this lesson is to understand View, ViewGroup and layouts. :

- All UI elements are subclasses of the `View` class, they are resources that can have an id. The `findViewById` call use the ID of a `View` as its parameter and return the `View`. 
- Learn how to use layout editor to design and edit the activity page. We can edit by `Design` view or `Code` view.
- There are three ways to set `layout_width` and `layout_height`:
	- The `match_constraint`.
	- The `wrap_content`.
	- A fixed number of `dp`.
- We can use `Ectracting string resources` to avoied hardcoded text.
- Learn how to create an `onClick` event.
- Learn hwo to display a toast message.
