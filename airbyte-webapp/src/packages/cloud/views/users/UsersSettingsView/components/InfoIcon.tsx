const InfoIcon = ({
  color = "currentColor",
}: {
  color?: string;
}): JSX.Element => (
  <svg width="14" height="14" viewBox="0 0 14 14" fill="none">
    <path
      d="M7.00016 13.6663C3.31816 13.6663 0.333496 10.6817 0.333496 6.99967C0.333496 3.31767 3.31816 0.333008 7.00016 0.333008C10.6822 0.333008 13.6668 3.31767 13.6668 6.99967C13.6668 10.6817 10.6822 13.6663 7.00016 13.6663ZM7.00016 12.333C8.41465 12.333 9.77121 11.7711 10.7714 10.7709C11.7716 9.77072 12.3335 8.41416 12.3335 6.99967C12.3335 5.58519 11.7716 4.22863 10.7714 3.22844C9.77121 2.22824 8.41465 1.66634 7.00016 1.66634C5.58567 1.66634 4.22912 2.22824 3.22893 3.22844C2.22873 4.22863 1.66683 5.58519 1.66683 6.99967C1.66683 8.41416 2.22873 9.77072 3.22893 10.7709C4.22912 11.7711 5.58567 12.333 7.00016 12.333ZM6.3335 3.66634H7.66683V4.99967H6.3335V3.66634ZM6.3335 6.33301H7.66683V10.333H6.3335V6.33301Z"
      fill={color}
    />
  </svg>
);

export default InfoIcon;
