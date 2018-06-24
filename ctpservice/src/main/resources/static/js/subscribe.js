function isString(value) {return typeof value === 'string';}
function isHeartbeatPing(e) { return (isString(e.data) && e.data === 'heartbeat ping');}

function jsonToArray (str) {
    const obj = JSON.parse(str);
    const result = [];
    for (let key in obj) {
        result.push(key);
        result.push(obj[key]);
    }
    return result;
}




