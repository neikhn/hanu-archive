// scroll for navigation links
document.querySelectorAll(".navigation_bar a[href^=#]").forEach(link => {
  addEventListener("click", (event) => {
    event.preventDefault();
    // get id inside the tag
    targetId = this.getAttribute("href");
    targetElement = document.querySelector(targetId);

    if (targetElement) {
      targetElement.scrollIntoView({
        behavior: "smooth",
        block: "start",
      });
    }
  })
});