import Message from "../schema/MessageSchema";

const message = async (req, res) => {
    const {recipient_id} = req.body;
    
    if (!recipient_id, msg, msg_type){
        return res.status(404).json({
        error: true,
        message: "Recipient ID not found",
        }) 
    }
}
const created = await Message.create({
    msg_type: preset_msg,

  });
