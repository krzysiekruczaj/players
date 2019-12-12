# Players example application

# Building application
`mvn clean package`

# Running application
`java -jar target/players-*.jar`

or
 
 `sh start.sh`

# Have every player in a separate JAVA process.

Current architecture allows to extend application to support networking. Idea that would allow to do this would be as following:
1. Networking solutions have been analyzed. Out of them I would choose either socket or RMI.
1. Client is registering to server in following steps:
    - Opens client connection
    - Connects to server input
    - Using server input to send connection message along with his input details
    - For each client that is registered, server create `ClientConnection` instance that stores client connection details
    - When new message appears in system, client's `ClientConnection` is fetched and used to send message
