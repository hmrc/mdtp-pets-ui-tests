#!/bin/bash

TEMP_FOLDER="tmp-test-script"
BACK_TWO_FOLDERS="../../"
REPO="example-ui-journey-tests-prototype"
BRANCH=$1
BROWSER=$2
ENVIRONMENT=$3

mkdir $TEMP_FOLDER
cd $TEMP_FOLDER
git clone https://github.com/hmrc/$REPO
cd $REPO
npm install
echo y | npm run dev > /dev/null 2>&1 & # The ampersand (&) is needed to run this task in the background and the echo y is to skip through an analytics question
cd $BACK_TWO_FOLDERS
git checkout ${BRANCH:=request-a-pet-journey}
sbt scalafmtSbt
sbt clean -Dbrowser="${BROWSER:=chrome}" -Denvironment="${ENVIRONMENT:=local}" -Dsecurity.assessment=false -Dbrowser.option.headless=false test testReport
