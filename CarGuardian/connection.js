import mongoose from "mongoose";
const URI =
  "mongodb+srv://admin:legionadmin@cluster0.kjpeo.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";

const connectDB = async () => {
  await mongoose.connect(URI, {
    useUnifiedTopology: true,
    useNewUrlParser: true,
  });
  console.log("DB Connected...");
};

export default connectDB;
