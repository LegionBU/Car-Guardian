import connectDB from "./connection";
import express from "express";
import sign from "./routes/signup";
import login from "./routes/login";
import userInfo from "./routes/userinfo";
import message from "./routes/message";

const app = express();

connectDB();

app.use(express.urlencoded({ extended: true }));
app.use(express.json());


app.post("/register", sign);
app.get("/login", login);
app.post("/userinfo", userInfo);
app.post("/message", message)

app.listen(3000, (error) => {
  if (error == null) {
    console.log("Legion");
  }
});
