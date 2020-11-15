import React from 'react';
import {default as store} from '../store/SlideStore'
import SlideListItem from "./SlideListItem";

class SlideList extends React.Component{

    constructor(props) {
        super(props);
        this.state = {slides : []};
        this._updateState = this._updateState.bind(this);
    }


    componentDidMount() {
        store.addChangeListener(this._updateState);
    }


    componentWillUnmount() {
        store.removeChangeListener(this._updateState);
    }

    _updateState(){
        this.setState({slides : store._slides});
    }

    render() {
        return(
            <div>
                <table className="table">
                    <thead>
                        <tr>
                            <th>Csúszda azonosító</th>
                            <th>Csúszda megnevezése</th>
                            <th>Ár / csúszás</th>
                        </tr>
                    </thead>
                    <tbody>
                    {this.state.slides.map(({slideId, name, price}, index)=>{
                        return(
                            <SlideListItem key={index} slideId={slideId} name={name} price={price}/>
                        );
                    })}
                    </tbody>
                </table>
            </div>
        );
    }
}

export default SlideList;
