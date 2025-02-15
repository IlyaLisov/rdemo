## Task 2

#### Description

You have a JSON string representing MyTube author account.

You need to parse this JSON into Java objects and do some operations on them:

1. Return user stats: number of videos, number of subscribers, number of views
   of all videos.

**NOTE:** `window` field is length of view in seconds. If it is one number, view
started from the start of video, else it is a range.

**NOTE:** View for author is counted if sum of viewed windows is longer than
30s.

2. Find the most viewed video and return its title, duration and views count.

3. Return all comments for each subscriber.

4. Find average view duration for each video in seconds and percents.

5. Find all spam comments. For each author return amount of spam
   comments.

**NOTE:** Spam comments are comments with urls to websites.

6. We want to understand how polite our community is. In polite community, more
   than 50% of entities (videos, comments) have positive rating (likes -
   dislikes > 0). Return entity type (`Video`, `Comment`), entity id, rating for
   all corresponding entities and result of 'polite' test.

**HINT:** For this task you need to use at least 2 abstract classes and 1
functional interface.

**HINT:** Use enums for persistent data types (find them).

**HINT:** Try to save entities in collections to reuse these objects in tasks.