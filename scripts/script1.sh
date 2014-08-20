#!/usr/bin/env bash
set -euo pipefail

echo "I'm a script. You're in $PWD." | tee script1-pwd.log

exit_arg=${1:-0}
case $exit_arg in
fail-randomly)
        exit_status=$(($RANDOM%2));;
*)
        exit_status=$exit_arg;;
esac

echo "Exiting with status: $exit_status"
exit $exit_status

