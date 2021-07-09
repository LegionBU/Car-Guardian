import { hash as createHash, genSalt } from "bcrypt";
import User from "../schema/UserSchema.js";
import generateQR from "../components/qrcode.js";

const sign = async (req, res) => {
  const { name, car_model, email, password, mobile, reg_no } = req.body;

  if (!name || !car_model || !email || !password || !mobile || !reg_no) {
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
    name: name,
    car_model: car_model,
    email_id: email,
    password: hash,
    mobile_number: mobile,
    registration_number: reg_no,
  });

  if (created) {

    const user = await User.findOne({email_id: email});
    const qr = await generateQR((user._id).toString());

    await User.findOneAndUpdate(
      {email_id:email},
      {
        $set:{
            qrcode: qr
        }
      }
    )

    const updatedUser = await User.findOne({email_id: email});

    return res.status(201).json({
      error: false,
      message: "User registered",
      user: updatedUser
    });
  } else {
    return res.status(500).json({
      error: true,
      message: "Error in creating user",
    });
  }
};

export default sign;
