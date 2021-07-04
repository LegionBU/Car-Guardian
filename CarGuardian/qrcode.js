import QRCode from "qrcode";
const qrgenerate = async (id) => {
  QRCode.toDataURL(id, { type: "terminal" }, function (err, url) {
    console.log(url);
  });
};
export default qrgenerate;
