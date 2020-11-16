docker run -it \
    -v ${PWD}/src:/usr/src/src \
    -v ${PWD}/scripts/run.sh:/usr/src/run.sh \
    -w /usr/src \
    openjdk:8-jdk
