import User from "../UserSchema";
import { compare } from "bcrypt";

const login = async (req, res) => {
  const { email, password } = req.body;

  if (!email || !password) {
    return res.status(401).json({
      error: true,
      message: "Invalid email or password",
    });
  }
  let existing = await User.findOne({
    email_id: email,
  }).exec();

  if (!existing) {
    return res.status(401).json({
      error: true,
      message: "Invalid email or password",
    });
  }
  const match = await compare(password, existing.password);
  if (!match) {
    return res.status(401).json({
      error: true,
      message: "Invalid email or password",
    });
  }
  let user = existing._doc;
  delete user.password;

  return res.status(200).json({
    error: false,
    message: "Successful fetch",
    user: existing,
  });
};

export default login;
