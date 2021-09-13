---
layout: default
title: Bingfan Tian
---

## Posts

<ul class="posts">
	{% for post in site.posts %}
	<li><span>{{ post.date | date_to_string }}</span> » <a href="/NEU_CS5520_21Fall{{ post.url }}" title="{{ post.title }}">{{ post.title }}</a></li>
	{% endfor %}
</ul>
