# NEU_CS5520_21Fall

### Welcome!

This is the repository I prepared for **CS5520** - Mobile Application Development - 2021 fall. You will see all the code I built for this course here. And I will also summarize the content learned in each lesson.

# Lessons

Here is the lessions that I took during this semester.

## Lesson 1_1 Android Studio and Hello World
Here is the [Link](https://github.com/BingfanTian96/NEU_CS5520_21Fall/tree/main/lesson1_1) to my code.

### Output:
<p float="left">
  <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/Lesson%201_1.png" width="300" />
</p>

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
<p float="left">
  <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson%201_2%20p1.png" width="300" />
  <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson%201_2%20p2.png" width="300" /> 
  <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson%201_2%20p3.png" width="300" />
</p>

P1: Output overview:  
P2: Click `TOAST` button to pop up a toast message.  
P3:Click `COUNT` button to increase the count in the text view.  


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

## Lesson 1_2_B The layout editor
Here is the [Link](https://github.com/BingfanTian96/NEU_CS5520_21Fall/tree/main/lesson1_2) to my code.

### Output:
<p float="left">
	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p4.png" />
    	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p5.png" />
    	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p6.png" />
    	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p7.png" width="300" />
  	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/lesson1_2%20p8.png" width="300" /> 
</p>
P1: Horizontal Layout:   
P2: Layout variant for tablets.   
P3: Horizontal layout variant for tablets.   
P4: LinearLayout.   
P5: RelativeLayout.    
 
The main purpose of this lesson is to learn how to use layout editor and other two different layout :

- -   Learn how to create variant of the layout that is different for a horizontal orientation, and to create variant of the layout that is different for a tablet
- There are three different layouts:
	- The `ConstraintLayout`.
	- The `LinearLayout`, this layout is a `ViewGroup` that arranges its collection of views in a horizontal or vertical row.
	- The `RelativeLayout`,  this layout is a `ViewGroup` in which each view is positioned and aligned relative to other views within the group.

### Homework:
- **Change an app**
	- Overview:
		<p float="left">
			<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW1.png" width="300"/>
			<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW2.png"/>
		</p>
	-	Function
		-  	<img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW3.png" width="300"/>
			- Click `count` button, then number in textView will increase. `Zero` button will change background  color because it is not Zero now. `Count` button will change background color because the number is odd.
		- <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW4.png"/>
		- Click `count` button, then number in textView will increase. `Count` button will change background color because the number is even.
		- <img src="https://github.com/BingfanTian96/NEU_CS5520_21Fall/blob/gh-pages/res/HW5.png" width="300"/>
		- Click `zero` button, then number in textView will become 0. `Count` button will change background color. `Zero` button also change background color.

- **Question 1**: Which two layout constraint attributes on the **Zero** `Button` position it vertically equal distance between the other two `Button` elements?
	-  `android:layout_marginBottom="8dp"`
	-  `android:layout_marginTop="8dp"`
- **Question 2**: Which layout constraint attribute on the **Zero** `Button` positions it horizontally in alignment with the other two `Button` elements?
	-  `app:layout_constraintLeft_toLeftOf="parent"`
- **Question 3**: What is the correct signature for a method used with the `android:onClick` XML attribute?
	-   `public void callMethod(View view)`
- **Question 4**: You see the statement in the **Logcat** pane if the Log level menu is set to which of the following?
	- Use the  `view`  parameter that is passed to the click handler with `setBackgroundColor()`
