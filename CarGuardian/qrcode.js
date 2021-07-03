var QRCode = require('qrcode')
const qrgenerate = async(id)=>{
    QRCode.toDataURL(id,{type:'terminal'}, function (err, url) {
        console.log(url)
      })
}
module.exports = qrgenerate
