Hash tables are a way to implement an associative array. It lets you associate a key with a value.

An hash table is composed of an array (with a fixed number of slots). To store a (key,value) pair, we use a function called an hashing funtion.
This function receives the key and returns the array index where the (key,value) will be stored.

There are a couple of rules for the hashing function:

 - If Key1 = Key2 => hash(Key1) = hash(Key2)
 - 0 <= hash(Key) <= length(array)
 - The hashing function needs to be uniformelly distributed, to ensure we use all space exsting on the array



We also have to deal with collisions, when hash(Key1) = hash(Key2). Collisions are bound to happen, because we use an array to store the data. There are two basic strategies to deal with this:

 - Separate chaining: The (key,value) pairs are not stored directly on the array. The array only contains a pointer to a bucket (can be a linked list). In that bucket we save all (key,value) pairs that have the same hash(key).
 - Open addressing: We store the (key,value) pairs directly on the array. We then use a strategy to find the next empty slot when an index is already being used. There are several ways to do this, but the most common are just transversing the array starting on the index hash(key), and moving to the right (linear probing). You cal also jump a few positions at a time (quadratic probing).

 In practice, open addressing starts to perform badly if 0.7 of the array is full, because at its limit you'll need O(n) to insert an entry, even if it's hash(key) is unique.

 Separate chaining only performs badly if there are lots of collisions.
 If this happens (load balance factor higher than 10) it might make sense to order the list, or use a tree structure, so that retrieving a key can be done in O(LogN).
