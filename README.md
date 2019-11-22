[![Build Status](https://travis-ci.com/breadoliveoilsalt/echo-server.svg?branch=master)](https://travis-ci.com/breadoliveoilsalt/echo-server)

# Echo Server

Welcome!

This echo server is written in Java.  Its build is handled by Gradle; the Gradle wrapper runs Gradle v5.6.2.  Tests are written with JUnit v4.12.

## Running the App Locally 

To run the echo server locally:

1. Fork this repository in GitHub and download/clone the master branch to your computer.

2. [Install Gradle](https://gradle.org/install/) if you don't have it already.

3. `cd` into the app's root directory.

4. The Gradle build for this particular app relies on git commit information found in a `.git` directory.  Therefore, to build or even run the app with Gradle, you will have initialize git within the project's root directory. To do so, run the following from the root directory, in order: 
    - `git init .`
    - `git add .`
    - `git commit -m "Initial commit"`
    
5. To start the app's server, run: `./gradlew run`.

6. To connect to the server and get a "Hey there" message back, open a new terminal window.  From this new window, you can then:
    - run `curl localhost:8000` OR
    - if your terminal can run bash scrips, `cd` into the app's root directory and run `./serverConnect`.   
    
The server app will then close.

To run a full build of the app without starting the server, run `./gradlew build`.

## Running the App's Tests

To run the tests for the app, after completing step 4 above, run the command `./gradlew test` from the app's root directory. 

Running `./gradlew build` will also run the tests.

## Contributions and License

### Contributing:

Bug reports and pull requests are welcome on GitHub at https://github.com/breadoliveoilsalt/echo-server. This project is intended to be a safe, welcoming space for collaboration, and contributors are expected to adhere to the Contributor Covenant (http://contributor-covenant.org) code of conduct.

### License:

The app is available as open pen source under the terms of the MIT License (http://opensource.org/licenses/MIT).

