import User from "../schema/UserSchema";

const userInfo = async(req, res) => {
    const {id} = req.body;
    console.log(id)
    const reqUser = await User.findOne({ _id: id})

    if(!reqUser){   
        res.status(404).json({
            error: true,
            message: "User not found"
        })
    }else{
        res.status(200).json({
            error: false,
            message: "User found",
            user: reqUser
        })
    }
} 


export default userInfo;