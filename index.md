---
layout: default
title: Bingfan Tian
---


### Welcome!

This is the repository I prepared for **CS5520** - Mobile Application Development - 2021 fall. You will see all the code I built for this course here. And I will also summarize the content learned in each lesson.

## Posts
<ul class="posts">

	  {% for post in site.posts %}
	    <li><span>{{ post.date | date_to_string }}</span> » <a href="/NEU_CS5520_21Fall{{ post.url }}" title="{{ post.title }}">{{ post.title }}</a></li>
	  {% endfor %}
	</ul>
