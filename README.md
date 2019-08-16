### Quotes
#### Feature Task
- Use quotes file provided (src/main/resources/quotes.json) and display a random quote and author from the file each time the application is run.
- Use GSON to parse the json file
- Get quotes from an API
- If internet is down, still read a quote from the file and return
- Write new quote to file if returned from internet

#### Approach
- Create a Quotes class
- Instantiate a FileReader object to read from file
- Instantiate a JsonReader object to read the file as a stream of JSON tokens
- Use the instantiated JsonReader and the structure of Quotes class to generate an array of quotes objects
- Generate a random number and use it as the index of the quotes array to return a random quote each time the app is run

#### To test
- Add the following dependency to the dependencies in build.gradle file
  - implementation 'com.google.code.gson:gson:2.8.5' 
  - Import/reconfigure all gradle projects to use this dependency
  - Check if following packages are imported and available
    - com.google.gson.Gson
    - com.google.gson.stream.JsonReader
    - java.io.FileNotFoundException
    - java.io.FileReader;

#### Collaborators
- Peter Lee
- Promila Tamang
- Padma Ganapathi
