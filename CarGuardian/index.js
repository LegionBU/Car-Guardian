import connectDB from "./connection";
import express from "express";
import sign from "./routes/signup";
import login from "./routes/login";

const app = express();

connectDB();

app.use(express.urlencoded({ extended: true }));
app.use(express.json());


app.post("/register", sign);
app.post("/login", login);

app.listen(3000, (error) => {
  if (error == null) {
    console.log("Legion");
  }
});
