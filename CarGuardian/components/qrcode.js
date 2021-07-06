import QRCode from "qrcode";

async function generateQR(id){
  const url = await QRCode.toDataURL(id);
  return url;
}

export default generateQR;
