import connectDB from "./connection";
import qrcode from "./qrcode";
import express from "express";
import sign from "./routes/signup";

const app = express();

connectDB();
qrcode("LALALA");

app.use(express.urlencoded({ extended: true }));
app.use(express.json());

app.post("/register", sign);

app.get("/about", (request, response) => {
  response.send("WE");
});

app.listen(3000, (error) => {
  if (error == null) {
    console.log("Legion");
  }
});
