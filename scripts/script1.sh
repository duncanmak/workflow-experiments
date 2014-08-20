#!/usr/bin/env bash

echo "I'm a script. You're in $PWD." | tee script1-pwd.log
echo "Exiting with status: $1"
exit $1

