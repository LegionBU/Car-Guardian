import mongoose from "mongoose";
const user = new mongoose.Schema({
  name: {
    type: String,
    required: true,
  },
  car_model: {
    type: String,
    required: true,
  },
  email_id: {
    type: String,
    required: true,
  },
  password: {
    type: String,
    required: true,
  },
  mobile_number: {
    type: String,
    required: true,
  },
  registration_number: {
    type: String,
    required: true,
  },
  qrcode:{
    type: String
  }
});

const User = mongoose.model("User", user);

export default User;
