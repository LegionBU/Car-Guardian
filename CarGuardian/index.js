const connectDB = require("./connection")
const qrcode = require("./qrcode")
const express = require("express")

const app = express()

connectDB()
qrcode("LALALA")

app.use(express.json({extended: true}))

app.get("/", (request, response)=>{
    response.send("Hello World");
})

app.get("/about", (request, response)=>{
    response.send("WE");
})

app.listen(3000, (error)=>{
    if (error == null ){
        console.log("Legion")
    }
})
