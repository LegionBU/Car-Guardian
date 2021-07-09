import message from "../schema/MessageSchema";

const message = async (req, res) => {
    const {recipient_id, msg, msg_type, image} = req.body;
    
    if (!recipient_id || !msg || !msg_type){
        return res.status(404).json({
        error: true,
        message: "Recipient ID not found",
        }) 
    }

const created = await Message.create({
    recipient_id: recipient_id,
    msg: msg,
    msg_type: msg_type,
    image: image,
    
  });

  if (created) {
      
    res.status(201).json({
        error: false,
        msg: created,
        message: "Message Sent",
      });
    } 
  else {
    res.status(500).json({
        error: true,
        message: "Error! Message not sent",
    });
};
}

export default message;
