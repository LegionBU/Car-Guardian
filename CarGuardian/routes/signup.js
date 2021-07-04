import { hash as createHash, genSalt } from "bcrypt";
import User from "../UserSchema";

const sign = async (req, res) => {
  const { name, username, email, password, mobile, regNo } = req.body;

  if (!name || !username || !email || !password || !mobile || !regNo) {
    return res.status(400).json({
      error: true,
      message: "Data not provided",
    });
  }
  const existing = await User.findOne({
    email_id: email,
    mobile_number: mobile,
  }).exec();

  if (existing) {
    return res.status(400).json({
      error: true,
      message: "User already exists",
    });
  }

  const saltRounds = 10;
  const salt = await genSalt(saltRounds);
  const hash = await createHash(password, salt);

  const created = await User.create({
    name,
    username,
    email_id: email,
    password: hash,
    mobile_number: mobile,
    registration_number: regNo,
  });

  if (created) {
    return res.status(201).json({
      error: false,
      message: "User registered",
    });
  } else {
    return res.status(500).json({
      error: true,
      message: "Error in creating user",
    });
  }
};

export default sign;
