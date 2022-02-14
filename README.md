# Running the solution
For running the solution, simply run the Main class!
# 1. The solution
Given we have a list of words, which might be unlimited and unique, I utilized a **TreeMap** data structure.
### Why TreeMap?
- **TreeMap** provides a Map which the keys store in **Sorted** ascending order.
- I could use **Map** data structure as well, if it is guaranteed the whole file is processed ones, i.e., a small size file that can be read once. Given the second part of the question, I used **TreeMap** to address the large file solution.
- Based on the fact the time complexity of adding and retrieving a key for **TreeMap** is **log(n)**, there should be a reasonable logic of choosing **TreeMap** instead of **Map**. In our case it is reasonable to have this complexity as it is discussed later.

### Algorithm
```
map = new TreeMap<String, List<String>>();
file = openFile('words.txt')
    
forEach(word in file->{
    char[] chArr= word.toLowerCase().toCharArray();
    Arrays.sort(chArr);
    
    String s = new String(chArr);

    if(map.containsKey(s)){
        map.get(s).add(word);
    }else {
        List<String> list = new ArrayList();
        list.add(word);
        map.put(s, list);
    }
});

map.forEach((key, value) -> {
        if (value.size()>1){
            print(value)
        }
    });
```



# 2. Correctness
- By imposing a **test.txt** file and using **unit tests**, I checked some cases as well as some corner case.
- In addition, given all the letters of a word is sorted and considered as the **Key** in **TreeMap**, it is guaranteed that all the words with the same set of letters have the same **key** (sorted list of all letters). Therefore, the solution ensures that all the Anagram words will be grouped to a single key, which is the sorted set of all letters of them. So, analytically, the solution is correct.

# 3. Complexity
### Time Complexity
- This algorithm has the time complexity of **O(n log(n))**.
- If **Map** is used instead of **TreeMap**, then the time complexity will be **O(n)**.
### Memory complexity
- O(n)

# 4. Large input file
### Problem
In this case, there would be two problems:
1. Reading a large file is costly and in some cases (limited amount of memory) is not feasible.
2. Given the *Memory complexity* of the solution, **O(n)**, it is impossible to fit all the words in memory.

### Solution
To address these problems, one solution is utilizing the **Map Reduce** concept.

##### Map phase
- The large file is read chuck by chunk
- For each chunk, the provided solution in section. 1 is used to process the current chunk. The final **map**, then is stored as a text file in the following format.
```aidl
key :[values]

e.g.
acer:[Race, Care, Acer]
aabq:[baqa, qaab, qbaa]
```
##### Reduce phase
- After processing all chunks, there are a limited number of intermediate files, which are **SOERTED** ascendingly (based on the **key**). The **Sorted** feature comes from using **TreeMap** in the main algorithm.
- Then, by implementing the **merge sorted arrays**, we can read all the intermediate files (chunks) and merge the same **keys**, through all files (chunks), and then print the result.
- **merge sorted arrays** gets a couple of arrays which are sorted. Then, merge them together in order to form one sorted large array. The time complexity of **merge sorted arrays** is **O(n)**, where *n* is the total number of elements in all arrays.

- **Note:** If the details of the **merge sorted arrays** is required, I will express it later as well.

# Conclusion 
I hope, the description is clear enough. If more detail is required please feel free to let me know or a clarification meeting will answer all the questions. 
