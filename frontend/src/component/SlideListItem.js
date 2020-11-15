import React from 'react';

function SlideListItem({slideId,name,price}){
    return (
        <tr>
            <td>{slideId}</td>
            <td>{name}</td>
            <td>{price}</td>
        </tr>
    );
}

export default SlideListItem;
