require('dotenv').config();
const express = require('express');
const axios   = require('axios');
const app     = express();

app.use(express.json());

app.post('/chat', async (req, res) => {
    const userMessage = req.body.message;

    try {
        const response = await axios.post(
            'https://api.groq.com/openai/v1/chat/completions',
            {
                model: "llama-3.1-8b-instant",
                messages: [{ role: "user", content: userMessage }]
            },
            {
                headers: {
                    'Authorization': `Bearer ${process.env.GROQ_API_KEY}`,
                    'Content-Type':  'application/json'
                }
            }
        );

        const botReply = response.data.choices[0].message.content;
        res.json({ reply: botReply });

    } catch (error) {
        console.error(error);
        res.status(500).send("Invalid response from server");
    }
});

app.listen(3000, () => console.log('Backend running on port 3000'));