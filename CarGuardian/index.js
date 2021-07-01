const express = require("express")
const app = express()
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
