# Cache
This is a low level design of a Cache system. Cache should support the following operations:

- `get(K key)`: The ability to access a value associated a key.
- `put(K key, V value)`: The ability to insert a key that associates to a value.
- `Cache(Storage, Policy)`: The ability to initialize the cache with any type of storage system and a replacement policy.
