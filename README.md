# Task 8.1 – LLM. ChatBot 

I have recently completed the task 8.1C, where I have developed an AI chatbot, using the GROQ API. 

In this application, I have also tried integrating with different API's, like Gemini, Google, etc. Then finally tried with GROQ as it has no credit limitations and works seamlessly.
User Authentication: Users enter a username to log in. The first letter of the username is dynamically used as the user's avatar icon throughout the chat interface.
AI-Powered Chat: Messages are sent to a Grok LLM backend and intelligent responses are returned in real time.
Time: Every message bubble displays a real-time timestamps. 
Chat History: All conversations are stored properly. When a user logs in back in with the same username, their full previous chat history is restored from the backend database.
API Key Handling: The Grok API key is stored in a server-side environment file (.env) and served through a Node.js backend (server.js). The environment file is excluded from version control via .gitignore, such that the key is never exposed publicly.
Wireframe: I have make sure that my UI is matching with the wireframes provided in the task sheet and added similar colors, fonts, layout, and user navigation, etc.
