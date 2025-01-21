#!/bin/bash

# This file is not a recommended approach to testing
# Please be aware that the contets of this script is not a solution to testing your prototypes

TEMP_FOLDER="tmp-test-script"
REPO="example-ui-journey-tests-prototype"

mkdir $TEMP_FOLDER
cd $TEMP_FOLDER
git clone https://github.com/hmrc/$REPO
cd $REPO
npm install
echo y | npm run dev > /dev/null 2>&1 & # The ampersand (&) is needed to run this task in the background and the echo y is to skip through an analytics question