/*price range*/

let slideIndex = 1;
showSlides(slideIndex);

// 3초마다 슬라이드 전환
setInterval(function () {
  plusSlides(1);
}, 3000);

function plusSlides(n) {
  showSlides((slideIndex += n));
}

function showSlides(n) {
  let i;
  const slides = document.getElementsByClassName("mySlides");
  if (n > slides.length) {
    slideIndex = 1;
  }
  if (n < 1) {
    slideIndex = slides.length;
  }
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";
  }
  slides[slideIndex - 1].style.display = "block";
}

$("#sl2").slider();

var RGBChange = function () {
  $("#RGB").css(
    "background",
    "rgb(" + r.getValue() + "," + g.getValue() + "," + b.getValue() + ")"
  );
};

/*scroll to top*/

$(document).ready(function () {
  $(function () {
    $.scrollUp({
      scrollName: "scrollUp", // Element ID
      scrollDistance: 300, // Distance from top/bottom before showing element (px)
      scrollFrom: "top", // 'top' or 'bottom'
      scrollSpeed: 300, // Speed back to top (ms)
      easingType: "linear", // Scroll to top easing (see http://easings.net/)
      animation: "fade", // Fade, slide, none
      animationSpeed: 200, // Animation in speed (ms)
      scrollTrigger: false, // Set a custom triggering element. Can be an HTML string or jQuery object
      //scrollTarget: false, // Set a custom target element for scrolling to the top
      scrollText: '<i class="fa fa-angle-up"></i>', // Text for element, can contain HTML
      scrollTitle: false, // Set a custom <a> title if required.
      scrollImg: false, // Set true to use image
      activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
      zIndex: 2147483647, // Z-Index for the overlay
    });
  });
});
