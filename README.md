# What is this codebase?
This is the Sauce Labs Sample Application which is designed to be used from desktop web browsers

![sample-app-web workflow](https://github.com/saucelabs/sample-app-web/actions/workflows/sample-app-web.yml/badge.svg)
[![codecov](https://codecov.io/gh/saucelabs/sample-app-web/branch/master/graph/badge.svg?token=Q4UsgDSRd3)](https://codecov.io/gh/saucelabs/sample-app-web)

- [Setup](#setup)
  - [Requirements](#requirements)
  - [Build](#build)
- [Test](#test)

## Setup
### Requirements
To set up the development environment directly on your host computer:

1. You’ll need [Node.js](http://nodejs.org) installed (at least v12.x.x or higher). If you don't have Node installed,
we recommend installing [NVM](https://github.com/creationix/nvm) to assist managing multiple active Node.js versions.
1. Install [OpenJDK 8](https://adoptopenjdk.net/) for running the end-to-end tests
1. Install [Google Chrome](https://www.google.com/chrome/) for running the end-to-end tests
1. Clone the project somewhere on your computer

        git clone git@github.com:<your-username>/sample-app-web.git

1. Install all dependencies by running this command from the **root of the project**

        npm install

### Build
1. Build the application with

        npm run start

    This will build the application, start Chrome and load the website on [http://localhost:3000/](http://localhost:3000/)

1. Click around - this is the app!

## Test
In this case, the tests are basic (there's only one) and these tests are written using Java with JUnit 4. You can see the `tests` directory for more details.
