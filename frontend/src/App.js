import React from 'react';
import './App.scss';
import ComplexNumberRecordingForm from "./component/ComplexNumberRecordingForm";
import ComplexNumberList from "./component/ComplexNumberList";
import WatchRecordingForm from "./component/WatchRecordingForm";
import WatchList from "./component/WatchList";
import SlideRecordingForm from "./component/SlideRecordingForm";
import SlideList from "./component/SlideList";
import Footer from "./component/footer/Footer"
import Navbar from "./component/navbar/Navbar";

function App() {
  return (
    <div className={["App","container"]}>
        <Navbar/>
        <main className={"container"}>
            <div className={"row"}>
                <div className={"col-md-3"}/>
                    <div className={"col-md-6"}>
                        <WatchRecordingForm/>
                        <WatchList/>
                        <SlideRecordingForm/>
                        <SlideList/>
                    </div>
                <div className={"col-md-3"}/>
            </div>
        </main>
        <Footer/>
    </div>

  );
}

export default App;
