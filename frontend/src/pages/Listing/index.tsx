import axios from "axios";
import MovieCard from "components/MovieCards";
import Pagination from "components/Pagination";
import { useState, useEffect } from "react";
import { MoviePage } from "types/movie";


function Listing() {

  const [pageNumber, setPageNumber] = useState(0);

  useEffect(() => {
    axios.get("http://localhost:8080/movies?size=128page=1")
      .then(response => {
        const data = response.data as MoviePage;
        setPageNumber(data.number);

      })
  }, []);

  return (
    <>
      <p>{pageNumber}</p>
      <Pagination />
      <div className="container">
        <div className="row">
          <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
            <MovieCard />
          </div>

        </div>
      </div>

    </>

  );
}

export default Listing;